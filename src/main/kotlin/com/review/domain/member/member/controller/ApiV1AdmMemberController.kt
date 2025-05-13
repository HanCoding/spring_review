package com.review.domain.member.member.controller

import com.review.domain.member.member.MemberDto
import com.review.domain.member.member.dto.MemberWithUsernameDto
import com.review.domain.member.member.service.MemberService
import com.review.standard.extensions.getOrThrow
import com.review.standard.search.MemberSearchKeywordTypeV1
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/adm/members")
class ApiV1AdmMemberController(private val memberService: MemberService) {

    @GetMapping
    fun items(
        @RequestParam(defaultValue = "all") searchKeywordType: MemberSearchKeywordTypeV1,
        @RequestParam(defaultValue = "") searchKeyword: String,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") pageSize: Int,
    ): Page<MemberWithUsernameDto> {
        return memberService.search(searchKeywordType, searchKeyword,page, pageSize)
            .map { MemberWithUsernameDto(it) }
    }

    @GetMapping("/{id}")
    fun item(
        @PathVariable id: Long
    ): MemberDto {
        return memberService.findById(id)
            .getOrThrow()
            .let {
                MemberDto(it)
            }
    }
}