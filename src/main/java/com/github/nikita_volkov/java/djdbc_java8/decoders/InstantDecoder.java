package com.github.nikita_volkov.java.djdbc_java8.decoders;

import djdbc.Decoder;

import java.sql.*;
import java.time.Instant;

public final class InstantDecoder extends Decoder.Rows<Instant> {

  private final int index;

  public InstantDecoder(int index) {
    this.index = index;
  }

  @Override
  public Instant run(ResultSet resultSet) throws SQLException {
    return resultSet.getTimestamp(index).toInstant();
  }

}
