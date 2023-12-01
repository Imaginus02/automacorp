<template>
  <div class="window border border-secondary rounded p-2 mb-2">
    <div class="top-row d-flex">
      <div class="window-name fw-bold pe-3">{{ window.name }}</div>
      <div class="open-status ms-4" :class="{'open' : window.windowStatus.value === 1.0, 'closed' : window.windowStatus.value === 0.0}">
        <template v-if="window.windowStatus.value === 1.0">
          <div>
            <span class="icon">&#x2B24;</span> Open
          </div>
        </template>
        <template>
          <div v-else>
            <span class="icon">&#x2716;</span> Closed
          </div>
        </template>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name:"WindowInRoomListItem",
  props: ['window']
}
</script>