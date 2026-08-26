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
 * Immutable properties of the Card API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardApiProperties">CardApiProperties</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public final class CardApiProperties {

  /**
   * Version of the API implemented by this binding, as a "MAJOR.MINOR" dotted decimal: {@value}
   *
   * @since 1.0.0
   */
  public static final String VERSION = "3.0";

  /** Private constructor */
  private CardApiProperties() {}
}
