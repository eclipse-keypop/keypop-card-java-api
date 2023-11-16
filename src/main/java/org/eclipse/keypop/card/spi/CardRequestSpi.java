/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.card.spi;

import java.util.List;
import org.eclipse.keypop.card.ApduResponseApi;

/**
 * Request grouping multiple APDUs to be executed consecutively.
 *
 * <p>Contains a list of {@link ApduRequestSpi} to be sent to a card and a flag indicating whether
 * to stop processing in case of an unexpected status word in response to one of the APDUs.
 *
 * @see ApduResponseApi
 * @since 1.0.0
 */
public interface CardRequestSpi {

  /**
   * Gets the list of {@link ApduRequestSpi}.
   *
   * @return A not empty list.
   * @since 1.0.0
   */
  List<ApduRequestSpi> getApduRequests();

  /**
   * Indicates if the processing of the requests must stop when an unexpected status word is
   * received.
   *
   * @return True if the process must stop at the first unsuccessful status word received.
   * @since 1.0.0
   */
  boolean stopOnUnsuccessfulStatusWord();
}
