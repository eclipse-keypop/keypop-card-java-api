/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.card;

/**
 * Indicates that the parsing of the card selection response has failed, the most likely reason
 * being that the Select Application command returned an invalid FCI structure.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_ParseException">ParseException</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public final class ParseException extends Exception {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0.0
   */
  public ParseException(String message) {
    super(message);
  }

  /**
   * @param message The message to identify the exception context.
   * @param cause The cause.
   * @since 1.0.0
   */
  public ParseException(String message, Throwable cause) {
    super(message, cause);
  }
}
