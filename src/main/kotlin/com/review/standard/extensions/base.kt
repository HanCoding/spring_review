package com.review.standard.extensions


// 확장 함수
// 어떤 타입도 될 수 있지만 Any를 상속해야 함
// 즉, null이 아닌 객체 타입만 가능
fun <T: Any>T?.getOrThrow(): T {
    return this?: throw NoSuchElementException()
}
fun <T : Any> T?.getOrDefault(default: T): T {
    return this ?: default
}