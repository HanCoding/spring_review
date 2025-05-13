package com.review.global.initData

import com.review.domain.member.member.repository.MemberRepository
import com.review.domain.member.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.transaction.annotation.Transactional

@Configuration
class NotProdInitData(
    private val memberService: MemberService
) {

    @Autowired
    @Lazy
    lateinit var self: NotProdInitData

    @Bean
    fun notProdInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            self.work1()
            self.work2()
        }
    }

    @Transactional
    fun work1() {
        if (memberService.count() > 0) return

        val memberSystem = memberService.join(
            username = "nopyu", password = "1234", name = "노퓨"
        )

        val memberAdmin = memberService.join(username = "pupu", password = "1234",
            name = "뿌뿌"
        )

        val memberUser1 = memberService.join(
            username = "user1", password = "1234", name = "유저1"
        )

        val memberUser2 = memberService.join(
            username = "user2", password = "1234", name = "유저2"
        )

        val memberUser3 = memberService.join(
            username = "user3", password = "1234", name = "유저3"
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

    @Transactional
    fun work2() {
        memberService.findByUsername("user3")?.let {
            it.name = "유저3-변경"
        }
    }
}