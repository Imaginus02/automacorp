<template>
  <div class="building border border-secondary rounded p-2 mb-2">
    <div class="top-row d-flex">
      <div class="window-name fw-bold pe-3">{{building.name}}</div>
      <div class="room-name text-muted">Nombre de salles : {{building.roomList.length}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BuildingListItem",
  props: ['building']
}
</script>
<style scoped lang="scss">

</style>