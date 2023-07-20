/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.card.spi;

/**
 * Marker interface providing run-time type information about data defining the
 * <b>org.eclipse.keypop.reader.selection.spi.SmartCard</b> resulting of the selection process
 * provided by the <b>Keypop Reader API</b>.
 *
 * <p>An adapter of this interface must also implement <b>SmartCard</b>.
 *
 * @since 1.0.0
 */
public interface SmartCardSpi {}
