import type { ValidationResult } from '@/types'

export const validatePdbId = (value: string): ValidationResult => {
  const trimmed = value.trim()
  
  if (!trimmed) {
    return {
      inputType: 'pdb',
      inputValue: value,
      isValid: false,
      message: '请输入PDB ID'
    }
  }
  
  const pdbPattern = /^[1-9][A-Za-z0-9]{3}$/
  if (!pdbPattern.test(trimmed)) {
    return {
      inputType: 'pdb',
      inputValue: value,
      isValid: false,
      message: 'PDB ID格式不正确',
      suggestions: ['格式应为4个字符，如1ABC']
    }
  }
  
  return {
    inputType: 'pdb',
    inputValue: value,
    isValid: true,
    message: '有效'
  }
}

export const validateUniProtId = (value: string): ValidationResult => {
  const trimmed = value.trim()
  
  if (!trimmed) {
    return {
      inputType: 'uniprot',
      inputValue: value,
      isValid: false,
      message: '请输入UniProt ID'
    }
  }
  
  const uniprotPattern = /^[A-Z][A-Z0-9]{5}$/
  if (!uniprotPattern.test(trimmed)) {
    return {
      inputType: 'uniprot',
      inputValue: value,
      isValid: false,
      message: 'UniProt ID格式不正确',
      suggestions: ['格式应为6个字符，以字母开头，如P01234']
    }
  }
  
  return {
    inputType: 'uniprot',
    inputValue: value,
    isValid: true,
    message: '有效'
  }
}

export const validateSmiles = (value: string): ValidationResult => {
  const trimmed = value.trim()
  
  if (!trimmed) {
    return {
      inputType: 'smiles',
      inputValue: value,
      isValid: false,
      message: '请输入SMILES字符串'
    }
  }
  
  const smilesPattern = /^[A-Za-z0-9@+\-\[\]()=#$.%&\/\\~`'"]+$/
  if (!smilesPattern.test(trimmed)) {
    return {
      inputType: 'smiles',
      inputValue: value,
      isValid: false,
      message: 'SMILES格式不正确',
      suggestions: ['请输入有效的SMILES分子表示']
    }
  }
  
  if (trimmed.length > 1000) {
    return {
      inputType: 'smiles',
      inputValue: value,
      isValid: false,
      message: 'SMILES字符串过长',
      suggestions: ['建议长度不超过1000字符']
    }
  }
  
  return {
    inputType: 'smiles',
    inputValue: value,
    isValid: true,
    message: '有效'
  }
}

export const validateCsvFile = (fileName: string): ValidationResult => {
  if (!fileName) {
    return {
      inputType: 'csv',
      inputValue: fileName,
      isValid: false,
      message: '请选择CSV文件'
    }
  }
  
  if (!fileName.toLowerCase().endsWith('.csv')) {
    return {
      inputType: 'csv',
      inputValue: fileName,
      isValid: false,
      message: '请选择CSV格式文件'
    }
  }
  
  return {
    inputType: 'csv',
    inputValue: fileName,
    isValid: true,
    message: '有效'
  }
}