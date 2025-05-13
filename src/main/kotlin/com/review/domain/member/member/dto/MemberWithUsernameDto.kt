package com.review.domain.member.member.dto

import com.review.domain.member.member.entity.Member

class MemberWithUsernameDto(
    val id: Long,
    val username: String,
    val name: String
) {
    constructor(member: Member) : this(
        id = member.id,
        username = member.username,
        name = member.name
    )
}
