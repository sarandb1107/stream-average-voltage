/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.example;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PowerRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7480513733752143404L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PowerRecord\",\"namespace\":\"org.example\",\"fields\":[{\"name\":\"Date\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"Time\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"Global_active_power\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Global_reactive_power\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Voltage\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Global_intensity\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Sub_metering_1\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Sub_metering_2\",\"type\":\"float\",\"default\":0.0},{\"name\":\"Sub_metering_3\",\"type\":\"float\",\"default\":0.0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PowerRecord> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PowerRecord> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PowerRecord> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PowerRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PowerRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PowerRecord to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PowerRecord from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PowerRecord instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PowerRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence Date;
  private java.lang.CharSequence Time;
  private float Global_active_power;
  private float Global_reactive_power;
  private float Voltage;
  private float Global_intensity;
  private float Sub_metering_1;
  private float Sub_metering_2;
  private float Sub_metering_3;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PowerRecord() {}

  /**
   * All-args constructor.
   * @param Date The new value for Date
   * @param Time The new value for Time
   * @param Global_active_power The new value for Global_active_power
   * @param Global_reactive_power The new value for Global_reactive_power
   * @param Voltage The new value for Voltage
   * @param Global_intensity The new value for Global_intensity
   * @param Sub_metering_1 The new value for Sub_metering_1
   * @param Sub_metering_2 The new value for Sub_metering_2
   * @param Sub_metering_3 The new value for Sub_metering_3
   */
  public PowerRecord(java.lang.CharSequence Date, java.lang.CharSequence Time, java.lang.Float Global_active_power, java.lang.Float Global_reactive_power, java.lang.Float Voltage, java.lang.Float Global_intensity, java.lang.Float Sub_metering_1, java.lang.Float Sub_metering_2, java.lang.Float Sub_metering_3) {
    this.Date = Date;
    this.Time = Time;
    this.Global_active_power = Global_active_power;
    this.Global_reactive_power = Global_reactive_power;
    this.Voltage = Voltage;
    this.Global_intensity = Global_intensity;
    this.Sub_metering_1 = Sub_metering_1;
    this.Sub_metering_2 = Sub_metering_2;
    this.Sub_metering_3 = Sub_metering_3;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Date;
    case 1: return Time;
    case 2: return Global_active_power;
    case 3: return Global_reactive_power;
    case 4: return Voltage;
    case 5: return Global_intensity;
    case 6: return Sub_metering_1;
    case 7: return Sub_metering_2;
    case 8: return Sub_metering_3;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Date = (java.lang.CharSequence)value$; break;
    case 1: Time = (java.lang.CharSequence)value$; break;
    case 2: Global_active_power = (java.lang.Float)value$; break;
    case 3: Global_reactive_power = (java.lang.Float)value$; break;
    case 4: Voltage = (java.lang.Float)value$; break;
    case 5: Global_intensity = (java.lang.Float)value$; break;
    case 6: Sub_metering_1 = (java.lang.Float)value$; break;
    case 7: Sub_metering_2 = (java.lang.Float)value$; break;
    case 8: Sub_metering_3 = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'Date' field.
   * @return The value of the 'Date' field.
   */
  public java.lang.CharSequence getDate() {
    return Date;
  }


  /**
   * Sets the value of the 'Date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.CharSequence value) {
    this.Date = value;
  }

  /**
   * Gets the value of the 'Time' field.
   * @return The value of the 'Time' field.
   */
  public java.lang.CharSequence getTime() {
    return Time;
  }


  /**
   * Sets the value of the 'Time' field.
   * @param value the value to set.
   */
  public void setTime(java.lang.CharSequence value) {
    this.Time = value;
  }

  /**
   * Gets the value of the 'Global_active_power' field.
   * @return The value of the 'Global_active_power' field.
   */
  public float getGlobalActivePower() {
    return Global_active_power;
  }


  /**
   * Sets the value of the 'Global_active_power' field.
   * @param value the value to set.
   */
  public void setGlobalActivePower(float value) {
    this.Global_active_power = value;
  }

  /**
   * Gets the value of the 'Global_reactive_power' field.
   * @return The value of the 'Global_reactive_power' field.
   */
  public float getGlobalReactivePower() {
    return Global_reactive_power;
  }


  /**
   * Sets the value of the 'Global_reactive_power' field.
   * @param value the value to set.
   */
  public void setGlobalReactivePower(float value) {
    this.Global_reactive_power = value;
  }

  /**
   * Gets the value of the 'Voltage' field.
   * @return The value of the 'Voltage' field.
   */
  public float getVoltage() {
    return Voltage;
  }


  /**
   * Sets the value of the 'Voltage' field.
   * @param value the value to set.
   */
  public void setVoltage(float value) {
    this.Voltage = value;
  }

  /**
   * Gets the value of the 'Global_intensity' field.
   * @return The value of the 'Global_intensity' field.
   */
  public float getGlobalIntensity() {
    return Global_intensity;
  }


  /**
   * Sets the value of the 'Global_intensity' field.
   * @param value the value to set.
   */
  public void setGlobalIntensity(float value) {
    this.Global_intensity = value;
  }

  /**
   * Gets the value of the 'Sub_metering_1' field.
   * @return The value of the 'Sub_metering_1' field.
   */
  public float getSubMetering1() {
    return Sub_metering_1;
  }


  /**
   * Sets the value of the 'Sub_metering_1' field.
   * @param value the value to set.
   */
  public void setSubMetering1(float value) {
    this.Sub_metering_1 = value;
  }

  /**
   * Gets the value of the 'Sub_metering_2' field.
   * @return The value of the 'Sub_metering_2' field.
   */
  public float getSubMetering2() {
    return Sub_metering_2;
  }


  /**
   * Sets the value of the 'Sub_metering_2' field.
   * @param value the value to set.
   */
  public void setSubMetering2(float value) {
    this.Sub_metering_2 = value;
  }

  /**
   * Gets the value of the 'Sub_metering_3' field.
   * @return The value of the 'Sub_metering_3' field.
   */
  public float getSubMetering3() {
    return Sub_metering_3;
  }


  /**
   * Sets the value of the 'Sub_metering_3' field.
   * @param value the value to set.
   */
  public void setSubMetering3(float value) {
    this.Sub_metering_3 = value;
  }

  /**
   * Creates a new PowerRecord RecordBuilder.
   * @return A new PowerRecord RecordBuilder
   */
  public static org.example.PowerRecord.Builder newBuilder() {
    return new org.example.PowerRecord.Builder();
  }

  /**
   * Creates a new PowerRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PowerRecord RecordBuilder
   */
  public static org.example.PowerRecord.Builder newBuilder(org.example.PowerRecord.Builder other) {
    if (other == null) {
      return new org.example.PowerRecord.Builder();
    } else {
      return new org.example.PowerRecord.Builder(other);
    }
  }

  /**
   * Creates a new PowerRecord RecordBuilder by copying an existing PowerRecord instance.
   * @param other The existing instance to copy.
   * @return A new PowerRecord RecordBuilder
   */
  public static org.example.PowerRecord.Builder newBuilder(org.example.PowerRecord other) {
    if (other == null) {
      return new org.example.PowerRecord.Builder();
    } else {
      return new org.example.PowerRecord.Builder(other);
    }
  }

  /**
   * RecordBuilder for PowerRecord instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PowerRecord>
    implements org.apache.avro.data.RecordBuilder<PowerRecord> {

    private java.lang.CharSequence Date;
    private java.lang.CharSequence Time;
    private float Global_active_power;
    private float Global_reactive_power;
    private float Voltage;
    private float Global_intensity;
    private float Sub_metering_1;
    private float Sub_metering_2;
    private float Sub_metering_3;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.example.PowerRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Date)) {
        this.Date = data().deepCopy(fields()[0].schema(), other.Date);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.Time)) {
        this.Time = data().deepCopy(fields()[1].schema(), other.Time);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.Global_active_power)) {
        this.Global_active_power = data().deepCopy(fields()[2].schema(), other.Global_active_power);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.Global_reactive_power)) {
        this.Global_reactive_power = data().deepCopy(fields()[3].schema(), other.Global_reactive_power);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.Voltage)) {
        this.Voltage = data().deepCopy(fields()[4].schema(), other.Voltage);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.Global_intensity)) {
        this.Global_intensity = data().deepCopy(fields()[5].schema(), other.Global_intensity);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.Sub_metering_1)) {
        this.Sub_metering_1 = data().deepCopy(fields()[6].schema(), other.Sub_metering_1);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.Sub_metering_2)) {
        this.Sub_metering_2 = data().deepCopy(fields()[7].schema(), other.Sub_metering_2);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.Sub_metering_3)) {
        this.Sub_metering_3 = data().deepCopy(fields()[8].schema(), other.Sub_metering_3);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing PowerRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(org.example.PowerRecord other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.Date)) {
        this.Date = data().deepCopy(fields()[0].schema(), other.Date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Time)) {
        this.Time = data().deepCopy(fields()[1].schema(), other.Time);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Global_active_power)) {
        this.Global_active_power = data().deepCopy(fields()[2].schema(), other.Global_active_power);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Global_reactive_power)) {
        this.Global_reactive_power = data().deepCopy(fields()[3].schema(), other.Global_reactive_power);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.Voltage)) {
        this.Voltage = data().deepCopy(fields()[4].schema(), other.Voltage);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.Global_intensity)) {
        this.Global_intensity = data().deepCopy(fields()[5].schema(), other.Global_intensity);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.Sub_metering_1)) {
        this.Sub_metering_1 = data().deepCopy(fields()[6].schema(), other.Sub_metering_1);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.Sub_metering_2)) {
        this.Sub_metering_2 = data().deepCopy(fields()[7].schema(), other.Sub_metering_2);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.Sub_metering_3)) {
        this.Sub_metering_3 = data().deepCopy(fields()[8].schema(), other.Sub_metering_3);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'Date' field.
      * @return The value.
      */
    public java.lang.CharSequence getDate() {
      return Date;
    }


    /**
      * Sets the value of the 'Date' field.
      * @param value The value of 'Date'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setDate(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.Date = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Date' field has been set.
      * @return True if the 'Date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Date' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearDate() {
      Date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'Time' field.
      * @return The value.
      */
    public java.lang.CharSequence getTime() {
      return Time;
    }


    /**
      * Sets the value of the 'Time' field.
      * @param value The value of 'Time'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setTime(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.Time = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'Time' field has been set.
      * @return True if the 'Time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'Time' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearTime() {
      Time = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'Global_active_power' field.
      * @return The value.
      */
    public float getGlobalActivePower() {
      return Global_active_power;
    }


    /**
      * Sets the value of the 'Global_active_power' field.
      * @param value The value of 'Global_active_power'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setGlobalActivePower(float value) {
      validate(fields()[2], value);
      this.Global_active_power = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'Global_active_power' field has been set.
      * @return True if the 'Global_active_power' field has been set, false otherwise.
      */
    public boolean hasGlobalActivePower() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'Global_active_power' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearGlobalActivePower() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'Global_reactive_power' field.
      * @return The value.
      */
    public float getGlobalReactivePower() {
      return Global_reactive_power;
    }


    /**
      * Sets the value of the 'Global_reactive_power' field.
      * @param value The value of 'Global_reactive_power'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setGlobalReactivePower(float value) {
      validate(fields()[3], value);
      this.Global_reactive_power = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'Global_reactive_power' field has been set.
      * @return True if the 'Global_reactive_power' field has been set, false otherwise.
      */
    public boolean hasGlobalReactivePower() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'Global_reactive_power' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearGlobalReactivePower() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'Voltage' field.
      * @return The value.
      */
    public float getVoltage() {
      return Voltage;
    }


    /**
      * Sets the value of the 'Voltage' field.
      * @param value The value of 'Voltage'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setVoltage(float value) {
      validate(fields()[4], value);
      this.Voltage = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'Voltage' field has been set.
      * @return True if the 'Voltage' field has been set, false otherwise.
      */
    public boolean hasVoltage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'Voltage' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearVoltage() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'Global_intensity' field.
      * @return The value.
      */
    public float getGlobalIntensity() {
      return Global_intensity;
    }


    /**
      * Sets the value of the 'Global_intensity' field.
      * @param value The value of 'Global_intensity'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setGlobalIntensity(float value) {
      validate(fields()[5], value);
      this.Global_intensity = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'Global_intensity' field has been set.
      * @return True if the 'Global_intensity' field has been set, false otherwise.
      */
    public boolean hasGlobalIntensity() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'Global_intensity' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearGlobalIntensity() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'Sub_metering_1' field.
      * @return The value.
      */
    public float getSubMetering1() {
      return Sub_metering_1;
    }


    /**
      * Sets the value of the 'Sub_metering_1' field.
      * @param value The value of 'Sub_metering_1'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setSubMetering1(float value) {
      validate(fields()[6], value);
      this.Sub_metering_1 = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'Sub_metering_1' field has been set.
      * @return True if the 'Sub_metering_1' field has been set, false otherwise.
      */
    public boolean hasSubMetering1() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'Sub_metering_1' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearSubMetering1() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'Sub_metering_2' field.
      * @return The value.
      */
    public float getSubMetering2() {
      return Sub_metering_2;
    }


    /**
      * Sets the value of the 'Sub_metering_2' field.
      * @param value The value of 'Sub_metering_2'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setSubMetering2(float value) {
      validate(fields()[7], value);
      this.Sub_metering_2 = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'Sub_metering_2' field has been set.
      * @return True if the 'Sub_metering_2' field has been set, false otherwise.
      */
    public boolean hasSubMetering2() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'Sub_metering_2' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearSubMetering2() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'Sub_metering_3' field.
      * @return The value.
      */
    public float getSubMetering3() {
      return Sub_metering_3;
    }


    /**
      * Sets the value of the 'Sub_metering_3' field.
      * @param value The value of 'Sub_metering_3'.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder setSubMetering3(float value) {
      validate(fields()[8], value);
      this.Sub_metering_3 = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'Sub_metering_3' field has been set.
      * @return True if the 'Sub_metering_3' field has been set, false otherwise.
      */
    public boolean hasSubMetering3() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'Sub_metering_3' field.
      * @return This builder.
      */
    public org.example.PowerRecord.Builder clearSubMetering3() {
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PowerRecord build() {
      try {
        PowerRecord record = new PowerRecord();
        record.Date = fieldSetFlags()[0] ? this.Date : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.Time = fieldSetFlags()[1] ? this.Time : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.Global_active_power = fieldSetFlags()[2] ? this.Global_active_power : (java.lang.Float) defaultValue(fields()[2]);
        record.Global_reactive_power = fieldSetFlags()[3] ? this.Global_reactive_power : (java.lang.Float) defaultValue(fields()[3]);
        record.Voltage = fieldSetFlags()[4] ? this.Voltage : (java.lang.Float) defaultValue(fields()[4]);
        record.Global_intensity = fieldSetFlags()[5] ? this.Global_intensity : (java.lang.Float) defaultValue(fields()[5]);
        record.Sub_metering_1 = fieldSetFlags()[6] ? this.Sub_metering_1 : (java.lang.Float) defaultValue(fields()[6]);
        record.Sub_metering_2 = fieldSetFlags()[7] ? this.Sub_metering_2 : (java.lang.Float) defaultValue(fields()[7]);
        record.Sub_metering_3 = fieldSetFlags()[8] ? this.Sub_metering_3 : (java.lang.Float) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PowerRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<PowerRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PowerRecord>
    READER$ = (org.apache.avro.io.DatumReader<PowerRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.Date);

    out.writeString(this.Time);

    out.writeFloat(this.Global_active_power);

    out.writeFloat(this.Global_reactive_power);

    out.writeFloat(this.Voltage);

    out.writeFloat(this.Global_intensity);

    out.writeFloat(this.Sub_metering_1);

    out.writeFloat(this.Sub_metering_2);

    out.writeFloat(this.Sub_metering_3);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.Date = in.readString(this.Date instanceof Utf8 ? (Utf8)this.Date : null);

      this.Time = in.readString(this.Time instanceof Utf8 ? (Utf8)this.Time : null);

      this.Global_active_power = in.readFloat();

      this.Global_reactive_power = in.readFloat();

      this.Voltage = in.readFloat();

      this.Global_intensity = in.readFloat();

      this.Sub_metering_1 = in.readFloat();

      this.Sub_metering_2 = in.readFloat();

      this.Sub_metering_3 = in.readFloat();

    } else {
      for (int i = 0; i < 9; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.Date = in.readString(this.Date instanceof Utf8 ? (Utf8)this.Date : null);
          break;

        case 1:
          this.Time = in.readString(this.Time instanceof Utf8 ? (Utf8)this.Time : null);
          break;

        case 2:
          this.Global_active_power = in.readFloat();
          break;

        case 3:
          this.Global_reactive_power = in.readFloat();
          break;

        case 4:
          this.Voltage = in.readFloat();
          break;

        case 5:
          this.Global_intensity = in.readFloat();
          break;

        case 6:
          this.Sub_metering_1 = in.readFloat();
          break;

        case 7:
          this.Sub_metering_2 = in.readFloat();
          break;

        case 8:
          this.Sub_metering_3 = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










