
Feature: Puzzle_Yapboz_Menusu
  Background: Giris
    Given Kitap Yurdu sitesine gidildi
    Then Kitap Yurdu sitesine gidildigi dogrulandi
    When Kategoriler ikonu tiklandi
    And "Kategoriler" bolumunde oldugu dogrulandi
    Then "Puzzle Yapboz" menusu tiklandi
    And "Puzzle Yapboz" bolumunde oldugu dogrulandi
  @puzzle
  Scenario: Ahsap Puzzle Menusu Testi
    Given "Ahşap Puzzle" menusu tiklandi
    When "Ahşap Puzzle" bolumunde oldugu dogrulandi
    Then "300 Parça" menusu tiklandi
    And "300 Parça" bolumunde oldugu dogrulandi
    Then "Panaromik" menusu tiklandi
    Then "Şehirler ve Yapılar Serisi" menusu tiklandi
    And "Şehirler ve Yapılar Serisi" bolumunde oldugu dogrulandi
    And Sayfada "Şehirler ve Yapılar Serisi" sayida urun oldugu dogrulandi

@hepsi
  Scenario: Çocuk Puzzle Menusu Testi
    Given "Çocuk Puzzle" menusu tiklandi
    When "Çocuk Puzzle" bolumunde oldugu dogrulandi
    Then "6-48 PARÇA" menusu tiklandi
    And "6-48 PARÇA" bolumunde oldugu dogrulandi
    And Sayfada "yazilan" sayida urun oldugu dogrulandi
  @swipe
  Scenario: Swipe Testi
    Given "Ahşap Puzzle" menusu tiklandi
    When "Ahşap Puzzle" bolumunde oldugu dogrulandi
    Then "1.000 Parça Ahşap Puzzle" menusu tiklandi
    And "1.000 Parça Ahşap Puzzle" bolumunde oldugu dogrulandi
    Then "Türk Sanatı Serisi" menusu tiklandi
    And "Türk Sanatı Serisi" bolumunde oldugu dogrulandi
    And Urunu tikladi
    And Urunu swipe yapti
  @hepsi
  Scenario: Çocuk Puzzle Menusu Testi
    Given "Çocuk Puzzle" menusu tiklandi
    When "Çocuk Puzzle" bolumunde oldugu dogrulandi
    Then "6-48 PARÇA" menusu tiklandi
    And "6-48 PARÇA" bolumunde oldugu dogrulandi
    And Sayfada kac urun oldugu yazdirildi

