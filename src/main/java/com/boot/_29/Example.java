package com.boot._29;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * jsoncomponent 注解 注册成spring的bean
 * All @JsonComponent beans in the ApplicationContext are automatically registered with Jackson
 *
 * Spring Boot also provides
 *  ---> JsonObjectSerializer
 * and
 * ---> JsonObjectDeserializer
 * base classes that provide useful alternatives to the standard Jackson versions
 * when serializing objects.
 */
@JsonComponent
public class Example {

	public static class Serializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		}
		// ...
	}

	public static class Deserializer extends JsonDeserializer<Object> {
		@Override
		public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			return null;
		}
		// ...
	}

}