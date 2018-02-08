package org.liyanxu.encoders;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.SchemaBuilder.StringBldr;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.Encoder;
import org.apache.avro.reflect.CustomEncoding;
import java.io.IOException;
import java.time.Instant;

public class InstantAsStringAvroEncoding extends CustomEncoding<Instant> {

    public InstantAsStringAvroEncoding() {
        // Define schema for this field
        this.schema = (Schema)((StringBldr) SchemaBuilder.builder().stringBuilder().prop
                ("CustomEncoding", InstantAsStringAvroEncoding.class.getName())).endString();
    }

    @Override
    protected void write(Object datum, Encoder encoder) throws IOException {
        encoder.writeString(datum.toString());
    }

    @Override
    protected Instant read(Object datum, Decoder decoder) throws IOException {
        try {
            return Instant.parse(decoder.readString());
        } catch (Exception e) {
            throw new IllegalStateException("Could not decode String into Instant", e);
        }
    }
}
