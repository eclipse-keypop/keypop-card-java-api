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

import java.io.Serializable;
import java.util.List;
import org.eclipse.keypop.card.spi.CardRequestSpi;

/**
 * Group of APDU responses received from the card after the execution of a {@link CardRequestSpi},
 * made serializable so that it can be transported across distributed boundaries.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#type_CardResponseApi">CardResponseApi</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardResponseApi extends Serializable {

  /**
   * Returns the responses received for the executed APDU requests, in the same order in which the
   * requests were submitted.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Card_v3.0.0-SNAPSHOT.html#op_CardResponseApi_getApduResponses">CardResponseApi.getApduResponses</a>
   * for the normative contract.
   *
   * @return A non-null list, empty if there is no response.
   * @since 1.0.0
   */
  List<ApduResponseApi> getApduResponses();
}
