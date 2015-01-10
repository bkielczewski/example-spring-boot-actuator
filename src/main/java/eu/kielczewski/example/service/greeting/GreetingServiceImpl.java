package eu.kielczewski.example.service.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
class GreetingServiceImpl implements GreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceImpl.class);

    private static final String[] GREETINGS = {
            "Yo!", "Hello", "Good day", "Hi", "Hey"
    };

    @Override
    public String getGreeting(int number) {
        LOGGER.debug("Getting greeting #{}", number);
        if (number < 1 || number > GREETINGS.length) {
            throw new NoSuchElementException(String.format("No greeting #%d", number));
        }
        return GREETINGS[number - 1];
    }

}
