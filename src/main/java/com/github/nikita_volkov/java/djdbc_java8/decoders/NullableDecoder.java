package com.github.nikita_volkov.java.djdbc_java8.decoders;

import djdbc.Decoder;

import java.sql.*;
import java.util.Optional;

public final class NullableDecoder<row> extends Decoder.Rows<Optional<row>> {

  private final int index;
  private final Rows<row> subDecoder;

  public NullableDecoder(int index, Rows<row> columnDecoder) {
    this.index = index;
    this.subDecoder = columnDecoder;
  }

  @Override
  public Optional<row> run(ResultSet resultSet) throws SQLException {
    if (resultSet.getObject(index) == null) return Optional.empty();
    else return Optional.of(subDecoder.run(resultSet));
  }

}
