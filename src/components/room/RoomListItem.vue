<template>
  <div class="window border border-secondary rounded p-2 mb-2" :class="{ expanded: isExpanded }">
    <div class="top-row d-flex" @click="toggleExpand">
      <div class="window-name fw-bold pe-3">{{ room.name }}</div>
      <div class="room-name text-muted">Floor {{ room.floor }}</div>
      <button class="btn btn-primary ms-auto">Details</button>
    </div>
    <hr>
    <window-in-room-list-item v-for="window in room.windowList" :window="window" :key="window.id"></window-in-room-list-item>
  </div>
</template>
<script>
import WindowInRoomListItem from "./WindowInRoomListItem.vue"

export default {
  name: "RoomListItem",
  props: ['room'],
  components: {
    WindowInRoomListItem,
  },
}
</script>