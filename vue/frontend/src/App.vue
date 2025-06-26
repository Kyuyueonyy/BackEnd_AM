<!-- <script setup>은 Vue 3에서 Composition API를 더 간단하게 쓸 수 있게 해주는문법임-->
<script setup>
// RouterView는 vue-router에서 제공하는 컴포넌트임
// 현재 URL 경로에따라맞는컴포넌트를화면에보여줌
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
</script>
<!-- 화면에보여줄HTML 구조정의하는부분임-->
<template>
  <DefaultLayout>
    <!-- RouterView는 라우터 설정에따라해당컴포넌트를이위치에표시함-->
    <RouterView />
  </DefaultLayout>
</template>
<!-- scoped는 이 CSS가 이컴포넌트에만적용되게제한해줌-->
<!-- scoped가 없으면다른컴포넌트를합했을때모두영향을미치게됨. 전역설정이됨. -->
<style scoped>
/* 아직 스타일없음*/
</style>
