package com.generator;

import org.apache.commons.cli.*;

public class CliParser {

    public void parse() {
        // Create parser
        CommandLineParser parser = new DefaultParser();

        // Create options
        Options opts = new Options();
        OptionGroup options = new OptionGroup();
//        options.addOption("h","help", false, "Show all commands");
//        options.addOption( "A", "almost-all", true, "do not list implied . and .." );
//        options.addOption("B", "ball", true, "gargarg");

        options.addOption(OptionBuilder
                .withDescription( "Create a new Test Class assigned to a Test Suite" )
                .withValueSeparator(',')
                .withLongOpt("class-name")
                .hasArgs()
                .withArgName("ClassName> <SuiteName")
                .create("c"));

        options.addOption(OptionBuilder
                .withDescription( "Create a new Test Class assigned to a Test Suite" )
                .withValueSeparator(' ')
                .withLongOpt("class-name")
                .hasArgs()
                .withArgName("ClassName> <SuiteName")
                .create("b"));

        opts.addOptionGroup(options);

        String[] args = new String[]{ "-c ergaergaer -b gaergaerg" };

        try {
            // parse the command line arguments
            CommandLine line = parser.parse( opts, args );

            if(line.hasOption("A")){
                System.out.println(line.getOptionValue("A"));
            }
            if(line.hasOption("B")){
                System.out.println(line.getOptionValue("B"));
            }

            if(line.hasOption("c")) {
                String[] arg = line.getOptionValues("c");
                System.out.println(arg[0]);
                for(String ar : arg) {
                    System.out.println(ar);
                }
            }

            if(line.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("CommandLineParameters", opts);
            }
        }
        catch( ParseException exp ) {
            System.out.println( "Unexpected exception:" + exp.getMessage() );
        }

    }

}
