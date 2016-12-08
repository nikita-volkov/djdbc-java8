package com.github.nikita_volkov.java.djdbc_java8.encoders;

import djdbc.Encoder;

import java.sql.*;
import java.time.Instant;

public final class InstantEncoder implements Encoder<Instant> {

  private final int index;

  public InstantEncoder(int index) {
    this.index = index;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, Instant instant) throws SQLException {
    preparedStatement.setTimestamp(index, Timestamp.from(instant));
  }

}
