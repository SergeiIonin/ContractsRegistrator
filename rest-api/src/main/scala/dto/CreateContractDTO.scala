package io.github.sergeiionin.contractsregistrator
package dto

import io.circe.{Encoder, Decoder}
import sttp.tapir.Schema

final case class ContractDTO(schemaType: String = "PROTOBUF", schema: String) derives Encoder, Decoder, Schema

final case class CreateContractDTO(schemaType: String = "PROTOBUF",
                                   name: String,
                                   schema: String) derives Encoder, Decoder, Schema
final case class CreateContractResponseDTO(name: String, id: Int) derives Encoder, Decoder, Schema

final case class DeleteContractDTO(name: String, id: Int) derives Encoder, Decoder, Schema
final case class DeleteContractResponseDTO(name: String, id: Int) derives Encoder, Decoder, Schema
