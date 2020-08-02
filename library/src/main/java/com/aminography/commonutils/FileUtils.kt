@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.net.Uri
import androidx.core.net.toFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.RandomAccessFile

/**
 * @author aminography
 */

val File.baseName: String
    get() = name.substringBeforeLast('.', name)

val File.extension: String
    get() = name.substringAfterLast('.', "")

fun Context.getExternalFile(sourceFile: File): File =
    File(getExternalFilesDir(null), sourceFile.name)

fun Context.getExternalCachedFile(sourceFile: File): File =
    File(externalCacheDir, sourceFile.name)

fun Uri.inputStream(): FileInputStream = toFile().inputStream()

fun Uri.outputStream(): FileOutputStream = toFile().outputStream()

fun Uri.randomAccessFile(): RandomAccessFile = RandomAccessFile(toFile(), "rw")

suspend fun FileInputStream.sizeSuspending(): Long =
    withContext(Dispatchers.IO) { channel.size() }

suspend fun FileInputStream.closeSuspending() =
    withContext(Dispatchers.IO) { close() }

suspend fun FileOutputStream.writeSuspending(bytes: ByteArray) =
    withContext(Dispatchers.IO) { write(bytes) }

suspend fun FileOutputStream.flushSuspending() =
    withContext(Dispatchers.IO) { flush() }

suspend fun FileOutputStream.closeSuspending() =
    withContext(Dispatchers.IO) { close() }

suspend fun RandomAccessFile.seekSuspending(position: Long) =
    withContext(Dispatchers.IO) { seek(position) }

suspend fun RandomAccessFile.writeSuspending(bytes: ByteArray) =
    withContext(Dispatchers.IO) { write(bytes) }

suspend fun RandomAccessFile.closeSuspending() =
    withContext(Dispatchers.IO) { close() }