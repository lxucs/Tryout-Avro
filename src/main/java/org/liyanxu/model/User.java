package org.liyanxu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.avro.reflect.AvroEncode;
import org.apache.avro.reflect.Nullable;
import org.liyanxu.encoders.InstantAsStringAvroEncoding;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private int age;

    private List<String> phoneNumbers;

    @Nullable
    private String company;

    @AvroEncode(using = InstantAsStringAvroEncoding.class)
    private Instant lastUpdate;

}
