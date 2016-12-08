package com.github.nikita_volkov.java.djdbc_java8.encoders;

import djdbc.Encoder;

import java.sql.*;
import java.util.function.Function;

public final class MappingEncoder<a, b> implements Encoder<a> {

  private final Encoder<b> encoder;
  private final Function<a, b> fn;

  public MappingEncoder(Encoder<b> encoder, Function<a, b> fn) {
    this.encoder = encoder;
    this.fn = fn;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, a a) throws SQLException {
    encoder.encodeParams(preparedStatement, fn.apply(a));
  }

}
