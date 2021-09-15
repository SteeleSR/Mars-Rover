package com.codurance.service;

import com.codurance.model.Command;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class CommandParser {

    public static List<Command> parseKnownCommands(String command) {
        return Arrays
                .stream(command.split(""))
                .map(CommandParser::findKnownCommand)
                .collect(toList());
    }

    private static Command findKnownCommand(String character) {
        List<Command> knownCommands = asList(Command.values());

        return knownCommands
                .stream()
                .filter(value -> value.input.equals(character))
                .findFirst()
                .get();
    }

}
