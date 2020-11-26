package com.chen17.doexcel.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 13:44
 */
public class JacksonUtil {

        public static ObjectMapper objectMapper;

        public JacksonUtil() {
        }

        public static <T> T readValue(String jsonStr, Class<T> valueType) {
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
            }

            try {
                return objectMapper.readValue(jsonStr, valueType);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef) {
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
            }

            try {
                return objectMapper.readValue(jsonStr, valueTypeRef);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String toJson(Object object) {
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
            }
            try {
                return objectMapper.writeValueAsString(object);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
