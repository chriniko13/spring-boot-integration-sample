package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.*;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomTicketCreator {

    public static final String DRAW_INFO = "DRAW_INFO";

    public static final int NO_OF_TICKETS = 20;

    private static final Map<Integer, Class<? extends Ticket>> ticketTypes = new HashMap<>();

    public RandomTicketCreator() {
        ticketTypes.put(1, Euromillions.class);
        ticketTypes.put(2, Magic4.class);
        ticketTypes.put(3, SwissLotto.class);
        ticketTypes.put(4, TrioMagic.class);
    }

    public List<Message<Ticket>> process(Message<DrawInfo> drawInfoMessage) {

        List<Ticket> createdTickets = IntStream.rangeClosed(1, NO_OF_TICKETS)
                .boxed()
                .map(idx -> {

                    ThreadLocalRandom randomGen = ThreadLocalRandom.current();

                    int ticketTypeToCreate = randomGen.nextInt(1, 5);

                    Class<? extends Ticket> ticketType = ticketTypes.get(ticketTypeToCreate);

                    Ticket createdTicket;

                    if (ticketType.equals(Euromillions.class)) {

                        Euromillions euromillions = new Euromillions();
                        euromillions.setId(UUID.randomUUID().toString());
                        euromillions.setRaffle(getRandomNum(50));
                        euromillions.setNumbers(getRandomNumbers(5, 50));

                        createdTicket = euromillions;

                    } else if (ticketType.equals(Magic4.class)) {

                        Magic4 magic4 = new Magic4();
                        magic4.setId(UUID.randomUUID().toString());
                        magic4.setNumbers(getRandomNumbers(4, 30));

                        createdTicket = magic4;

                    } else if (ticketType.equals(SwissLotto.class)) {

                        SwissLotto swissLotto = new SwissLotto();
                        swissLotto.setId(UUID.randomUUID().toString());
                        swissLotto.setBoardOneNumbers(getRandomNumbers(5, 50));
                        swissLotto.setBoardTwoNumbers(getRandomNumbers(2, 30));

                        createdTicket = swissLotto;

                    } else if (ticketType.equals(TrioMagic.class)) {

                        TrioMagic trioMagic = new TrioMagic();
                        trioMagic.setId(UUID.randomUUID().toString());
                        trioMagic.setNumbers(getRandomNumbers(3, 30));

                        createdTicket = trioMagic;

                    } else {
                        throw new IllegalStateException();
                    }

                    createdTicket.setDrawNumber(drawInfoMessage.getPayload().getDrawNumber());
                    return createdTicket;
                })
                .collect(Collectors.toList());

        return createdTickets
                .stream()
                .map(createdTicket -> MessageBuilder
                        .withPayload(createdTicket)
                        .copyHeadersIfAbsent(drawInfoMessage.getHeaders())
                        .setHeader(DRAW_INFO, drawInfoMessage.getPayload())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private List<String> getRandomNumbers(int howMany, int boundInclusive) {
        return IntStream.rangeClosed(1, howMany)
                .boxed()
                .map(idx -> getRandomNum(boundInclusive))
                .collect(Collectors.toList());
    }

    private String getRandomNum(int boundInclusive) {
        int random = ThreadLocalRandom.current().nextInt(1, boundInclusive + 1);
        return String.valueOf(random);
    }

}
