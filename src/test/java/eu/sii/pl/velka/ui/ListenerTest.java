package eu.sii.pl.velka.ui;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import eu.sii.pl.velka.ui.viewfactory.ResponseFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class ListenerTest {

    private Listener listener ;

    @Before
    public void setUp(){
        listener = new Listener(new SessionMap(), new ResponseFactory());
    }

    @Test
    public void shouldLogMissingCorrelactionId() {
        //given
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        final Appender mockAppender = mock(Appender.class);
        when(mockAppender.getName()).thenReturn("MOCK");
        root.addAppender(mockAppender);

        //when
        listener.consume(new ActiveMQTextMessage());

        //then
        verify(mockAppender).doAppend(argThat((ArgumentMatcher) argument -> ((LoggingEvent) argument).getFormattedMessage().contains("Received TextMessage without correlationId")));
    }
}