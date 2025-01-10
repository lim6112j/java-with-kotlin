package com.ciel.kotlin_library
import org.springframework.stereotype.Component
import org.springframework.kafka.annotation.KafkaListener
import org.slf4j.LoggerFactory

@Component
class ExampleStringConsumer {
		private val logger = LoggerFactory.getLogger(this.javaClass)
		@KafkaListener(topics = [EXAMPLE_TOPIC_NAME], groupId = GROUP_ID)
		fun firstListener(message: String){
				logger.info("Message received: [$message]")
		}
}
