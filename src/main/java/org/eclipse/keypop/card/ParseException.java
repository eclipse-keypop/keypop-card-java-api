/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.card;

/**
 * Indicates that the parsing of the card selection response has failed.
 *
 * <p>The most likely reason is that the select application command returned an invalid FCI
 * structure.
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
