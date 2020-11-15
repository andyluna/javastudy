package org.apache.rocketmq.example.test;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import java.util.Arrays;

/**
 * @time: 2020/11/10 十一月 11:24
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CommandLineTest {

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("h", "help", false, "print options' information");
        options.addOption("d", "database", true, "name of a database");
        options.addOption("t", true, "name of a table");

        Option filesOption = OptionBuilder.withArgName("args")
                .withLongOpt("files")
                .hasArgs()
                .withDescription("file names")
                .create("f");
        options.addOption(filesOption);
        String[] params = new String[]{ "-d database -t table -files file1 file2" };

       // "-database database -t table -files file1 file2"

        CommandLineParser parser = new BasicParser();
        try {
            CommandLine cli = parser.parse(options, params);
            if(cli.hasOption("h")){
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
            }
            else {
                String database = cli.getOptionValue("d");
                System.out.println("database: " + database);
                String table = cli.getOptionValue("t");
                System.out.println("table: " + table);
                String[] files = cli.getOptionValues("f");
                System.out.println("files: " + Arrays.asList(files));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

}
