package com.review.domain.member.member

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class ApiV1MemberController {

    @GetMapping("/me")
    fun me(): List<MemberDto> {

        return listOf(
            MemberDto(1, "John Doe"),
            MemberDto(2, "Jane Doe")
        )
    }
}