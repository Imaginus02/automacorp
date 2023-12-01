<template>
  <div class="modal-background" v-if="isVisible">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
          Are you sure you want to delete Window 2?
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" @click="close">Close</button>
          <button type="button" class="btn btn-primary" @click="confirm">Confirm</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  name: 'PopupModal',

  data: () => ({
    isVisible: false,
    concernedWindow: 0,
  }),

  methods: {
    open() {
      this.isVisible = true
    },

    confirm() {
      this.$emit('confirm');
    },

    cancel() {
      this.$emit('cancel');
    },
    close() {
      this.isVisible = false;
    },
    changeWindow(id) {
      this.concernedWindow = id;
    }
  },
}
</script>

<style lang="scss" scoped>
</style>