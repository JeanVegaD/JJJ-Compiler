package org.apache.hadoop.fs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.FileStatus

class FileSystem {
	def get(conf: Configuration) : FileSystem;
	def globStatus(pathPattern: Path): Array[FileStatus]
}