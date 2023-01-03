package br.com.apimanager.resource

import br.com.apimanager.service.ApiManagerService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File


@RestController
@RequestMapping("/api")
class ApiMangerController(private val apiManagerService: ApiManagerService) {

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        val fileName = file.originalFilename
        apiManagerService.uploadFile(file)
        return ResponseEntity.ok("File $fileName uploaded successfully")
    }

    @ApiOperation(value = "Download file from S3 bucket")
    @GetMapping("/download")
    fun downloadFile(@RequestParam("fileKey") fileKey: String): ResponseEntity<File> {
        val file = apiManagerService.downloadFile(fileKey)
        return ResponseEntity(file, HttpStatus.OK)
    }

    @ApiOperation(value = "Get list of files in S3 bucket")
    @GetMapping("/s3")
    fun getFiles(): ResponseEntity<List<String>> {
        val files = apiManagerService.getFiles()
        return ResponseEntity(files, HttpStatus.OK)
    }
}