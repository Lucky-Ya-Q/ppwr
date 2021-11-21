import request from '@/utils/request'

// 查询农药库存列表
export function listInventory(query) {
  return request({
    url: '/test/inventory/list',
    method: 'get',
    params: query
  })
}

// 查询农药库存详细
export function getInventory(id) {
  return request({
    url: '/test/inventory/' + id,
    method: 'get'
  })
}

// 新增农药库存
export function addInventory(data) {
  return request({
    url: '/test/inventory',
    method: 'post',
    data: data
  })
}

// 修改农药库存
export function updateInventory(data) {
  return request({
    url: '/test/inventory',
    method: 'put',
    data: data
  })
}

// 删除农药库存
export function delInventory(id) {
  return request({
    url: '/test/inventory/' + id,
    method: 'delete'
  })
}

// 导出农药库存
export function exportInventory(query) {
  return request({
    url: '/test/inventory/export',
    method: 'get',
    params: query
  })
}