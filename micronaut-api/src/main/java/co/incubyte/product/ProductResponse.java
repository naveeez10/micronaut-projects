package co.incubyte.product;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public record ProductResponse(String id, String name,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "IST" ) OffsetDateTime createdAt,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "IST") OffsetDateTime updatedAt) {

}
