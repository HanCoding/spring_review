package com.review.global.initData

import com.review.domain.member.member.service.MemberService
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotProdInitData(
    private val memberService: MemberService
) {

    @Bean
    fun notProdInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            if (memberService.count() > 0) {
                return@ApplicationRunner
            }
            
            val memberSystem = memberService.join(
                username = "system",
                password = "1234",
                name = "시스템"
            )

            val memberAdmin = memberService.join(
                username = "admin",
                password = "1234",
                name = "관리자"
            )

            val memberUser1 = memberService.join(
                username = "user1",
                password = "1234",
                name = "유저1"
            )

            val memberUser2 = memberService.join(
                username = "user2",
                password = "1234",
                name = "유저2"
            )

            val memberUser3 = memberService.join(
                username = "user3",
                password = "1234",
                name = "유저3"
            )

            listOf(
                memberSystem,
                memberAdmin,
                memberUser1,
                memberUser2,
                memberUser3
            ).forEach {
                println(it)
            }
        }
    }
}