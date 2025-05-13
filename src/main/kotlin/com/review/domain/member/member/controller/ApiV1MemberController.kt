package com.review.domain.member.member.controller

import com.review.domain.member.member.MemberDto
import com.review.domain.member.member.service.MemberService
import com.review.standard.extensions.getOrThrow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class ApiV1MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/me")
    fun me(): MemberDto {
        return memberService
            .findByUsername("user1")
            .getOrThrow()
            .let {
                MemberDto(it)
            }
    }
}