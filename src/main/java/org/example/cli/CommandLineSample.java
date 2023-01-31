package org.example.cli;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineSample {
    public static void main(String[] args) throws ParseException {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage info");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");
        options.addOption("f", "file", true, "File to save program output to");

        CommandLine commandLine = parser.parse(options, args);

        boolean verbose = false;
        String file = "";

        if (commandLine.hasOption("h")) {
            System.out.println("Help message");
            System.exit(0);
        }
        if (commandLine.hasOption("v")) {
            System.out.println("VERBOSE MODE: ON");
            verbose = true;
        }

        if (commandLine.hasOption("f")) {
            file = commandLine.getOptionValue("f");
        }
    }
}
