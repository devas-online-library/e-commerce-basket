package tech.ada.basket.ecommerce.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.payload.response.ToInformErrorResponse;
import tech.ada.basket.ecommerce.service.ShipErrorHandlerService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformShipErrorConsumer {
    private final ObjectMapper objectMapper;
    private final ShipErrorHandlerService shipErrorHandlerService;

    @RabbitListener(queues = {"${domain.ship.queue}"})
    public void consumer(Message message , Channel channel)  {
        try {
            String mensageString = new String(message.getBody());
            ToInformErrorResponse toInformError = objectMapper.readValue(mensageString,ToInformErrorResponse.class);
            log.info("Shipping error message consumed {}", toInformError);
            shipErrorHandlerService.execute(toInformError);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
