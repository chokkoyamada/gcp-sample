package com.kirishikistudios.gcpsample

import com.google.cloud.storage.{BucketInfo, Storage, StorageOptions}
import scala.collection.JavaConverters._

object CloudStorage extends App {
  val storage: Storage = StorageOptions.getDefaultInstance.getService
  val bucketName = "yamada-test-201707192037"
  val exist = storage.list().iterateAll().iterator().asScala.toList.find(_.getName == bucketName)
  exist match {
    case Some(n) => println(s"Bucket $bucketName already exist.")
    case None =>  createBucket(bucketName)
  }

  def createBucket(name: String) = {
    val bucket = storage.create(BucketInfo.of(bucketName))
    println(s"Bucket $bucketName created.")
  }
}



