package eu.sii.pl.velka.ui;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class ListenerTest {

    Listener listener = new Listener();

    @Test
    public void shouldLogMissingCorrelactionId() {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        final Appender mockAppender = mock(Appender.class);
        when(mockAppender.getName()).thenReturn("MOCK");
        root.addAppender(mockAppender);

        listener.consume(new ActiveMQTextMessage());

        verify(mockAppender).doAppend(argThat((ArgumentMatcher) argument -> ((LoggingEvent) argument).getFormattedMessage().contains("Received TextMessage without correlationId")));
    }
}