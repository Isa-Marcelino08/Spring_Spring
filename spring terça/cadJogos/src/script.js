// script.js

// Armazenamento de dados
let jogos = JSON.parse(localStorage.getItem("jogos")) || [];

// Função para renderizar a lista de jogos
function renderizarJogos() {
    console.log("Jogos cadastrados:", jogos);
}

// Função para cadastrar um jogo
document.getElementById('cadastroForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const nome = document.getElementById('gameName').value;
    const plataforma = document.getElementById('gamePlatform').value;

    if (nome && plataforma) {
        const jogo = {
            id: jogos.length ? jogos[jogos.length - 1].id + 1 : 1,
            nome: nome,
            plataforma: plataforma
        };
        
        jogos.push(jogo);
        localStorage.setItem('jogos', JSON.stringify(jogos));
        
        // Limpar os campos do formulário
        document.getElementById('gameName').value = '';
        document.getElementById('gamePlatform').value = '';
        
        alert('Jogo cadastrado com sucesso!');
        renderizarJogos();
    } else {
        alert('Por favor, preencha todos os campos.');
    }
});

// Função para atualizar um jogo
document.querySelector('.updateBtn').addEventListener('click', function (event) {
    event.preventDefault();
    
    const id = parseInt(document.getElementById('gameId').value);
    const nome = document.getElementById('gameName').value;
    const plataforma = document.getElementById('gamePlatform').value;
    
    if (id && nome && plataforma) {
        const jogoIndex = jogos.findIndex(jogo => jogo.id === id);
        
        if (jogoIndex !== -1) {
            jogos[jogoIndex] = { id, nome, plataforma };
            localStorage.setItem('jogos', JSON.stringify(jogos));
            
            alert('Jogo atualizado com sucesso!');
            renderizarJogos();
            
            // Limpar os campos do formulário
            document.getElementById('gameId').value = '';
            document.getElementById('gameName').value = '';
            document.getElementById('gamePlatform').value = '';
        } else {
            alert('Jogo não encontrado!');
        }
    } else {
        alert('Por favor, preencha todos os campos.');
    }
});

// Função para excluir um jogo
document.querySelector('.deleteBtn').addEventListener('click', function (event) {
    event.preventDefault();
    
    const id = parseInt(document.getElementById('gameId').value);
    
    if (id) {
        const jogoIndex = jogos.findIndex(jogo => jogo.id === id);
        
        if (jogoIndex !== -1) {
            jogos.splice(jogoIndex, 1);
            localStorage.setItem('jogos', JSON.stringify(jogos));
            
            alert('Jogo excluído com sucesso!');
            renderizarJogos();
            
            // Limpar o campo do ID do formulário
            document.getElementById('gameId').value = '';
        } else {
            alert('Jogo não encontrado!');
        }
    } else {
        alert('Por favor, insira o ID do jogo.');
    }
});

// Função para pesquisar um jogo
document.querySelector('.searchBtn').addEventListener('click', function (event) {
    event.preventDefault();
    
    const id = parseInt(document.getElementById('gameId').value);
    
    if (id) {
        const jogo = jogos.find(jogo => jogo.id === id);
        
        if (jogo) {
            alert(`Jogo encontrado: \nNome: ${jogo.nome} \nPlataforma: ${jogo.plataforma}`);
        } else {
            alert('Jogo não encontrado!');
        }
    } else {
        alert('Por favor, insira o ID do jogo.');
    }
});

// Chamar renderizarJogos ao carregar a página
renderizarJogos();
