package com.review.domain.member.member

import com.review.domain.member.member.entity.Member

class MemberDto(
    val id: Long,
    val name: String
) {
    constructor(member: Member): this(
        id = member.id,
        name = member.name
    )
}