package com.kirishikistudios.gcpsample

import com.google.cloud.storage.{BucketInfo, Storage, StorageOptions}

import scala.collection.JavaConverters._

object CloudStorage extends App {
  val storage: Storage = StorageOptions.getDefaultInstance.getService
  val bucketName = "yamada-test-201707192037"
  val exist = storage.list().iterateAll().iterator().asScala.toList.find(_.getName == bucketName)
  val result = exist match {
    case Some(_) => s"Bucket $bucketName already exist."
    case None => createBucket(bucketName)
  }
  println(result)

  def createBucket(name: String): String = {
    storage.create(BucketInfo.of(name))
    s"Bucket $bucketName created."
  }
}
