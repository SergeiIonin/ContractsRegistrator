package io.github.sergeiionin

// fixme rename to contractsregistry
package object contractsregistrator:
  opaque type Bytes = Array[Byte]
  object Bytes:
    def apply(arr: Array[Byte]): Bytes = arr
    def toString(bytes: Bytes): String = 
      val raw: Array[Byte] = bytes
      new String(raw)

