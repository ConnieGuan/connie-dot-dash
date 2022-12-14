package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DemoApplication implements ApplicationRunner {
	@Value("${option.value}")
	private static String OPTION_NAME="option.value";

	private String HELP_STRING = "\n The client app will accept the following command line arguments: \n" +
			"--help Output a usage message and exit\n" +
            "-s, --search _TERMS_ Search the Goodreads' API and display the results on screen. \n" +
			"Results must include author, title, and a link or display of the image of the book\n" +
			"-s --sort _FIELD_ where field is one of 'author' or 'title'\n" +
			"Sorts the results by the specified field, if no sort is specified, title is the default\n" +
			"-p _NUMBER_ if you choose to implement pagination, display the _NUMBER_ page of results\n" +
			"-h, --host _HOSTNAME_ the hostname or ip address where the server can be found, should \n"+
			"default to 127.0.0.1";


	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(DemoApplication.class, args);
		log.info("Ending application");
	}


	/* AKA: the client
	 * NOTE: Springboot wasn't a great option here since it's not really designed to take in command line input
	 * I've done the best I can with what springboot provides, but if we really want a command line interface,
	 * then we'd have to use a different framework here.
	 *
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));

		// if no option was specified print the help message and end the program
		if(!args.containsOption(OPTION_NAME)) {
			log.error("Please specify a valid option. See help message below");
			log.error(HELP_STRING);
			return;
		}

		// NOTE: for the purpose of demo, not sanitizing this input. Let's assume it's correct
		List<String> option = args.getOptionValues(OPTION_NAME);

		switch (option.get(0)) {
			case "help":
				log.info(HELP_STRING);
				break;
			case "s":
			case "search":
				log.info("SEARCH");
				// call controller search api here, passing in future c

				// NOTE: there are a couple different ways to do sort on top of search
				// the most straightforward (with the command line interface)
				// would be to check here if the sort option was passed
				// the more springboot way to approach this would be to have an additional
				// param on the GET api call to sort
				break;

// NOTE: another option for sort, if this was more "state defined" app, would be to have sort be a "mode"
// that users could toggle. For a small demo app that is probably the quickest method. For a larger app
// I would recommend going with the API query method mentioned above. I've left this case in though since
// technically this demo IS a small app

//			case "sort":
//				log.info("SORT");
//				//
//				break;

// NOTE: See above discussion re: "modes". Pagination could also be a mode that is togglable.
// But again for anything larger than this demo, I would lean towards having pagination being a param for the GET
			case "p":
				log.info("PAGINATION");
				break;
			case "h":
			case "host":
				log.info("HOST");
				// NOTE: not too much to say here. The spring boot-y way to do this is to have the host info set
				// in some property file that could be read out here.
				break;
			default:
				log.info("Please specify a valid option. See help message below");
				log.info(HELP_STRING);
		}
	}
}
