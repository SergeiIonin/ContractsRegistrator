package io.github.sergeiionin.contractsregistrator
package config

import pureconfig.*
import pureconfig.generic.derivation.default.*

final case class KafkaProducerConfig(
                                    prsTopic: String,
                                    bootstrapServers: List[String],
                                    ) derives ConfigReader
