package br.com.apimanager.service

import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import org.springframework.web.multipart.MultipartFile
import java.io.File

@Service
class ApiManagerService {

    fun uploadFile(file: MultipartFile) {
        val fileToUpload = convertMultipartFileToFile(file)
        fileToUpload.delete()
        TODO("Not yet implemented")
    }

    fun downloadFile(fileKey: String): File {
        TODO("Not yet implemented")
    }

    fun getFiles(): MultiValueMap<String, String> {
        TODO("Not yet implemented")
    }

    fun convertMultipartFileToFile(multipartFile: MultipartFile): File {
        val file = File.createTempFile("temp-file", null)
        file.deleteOnExit()
        multipartFile.transferTo(file)
        return file
    }
}